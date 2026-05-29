<template>
  <div class="page">

    <!-- HEADER -->
    <header class="header shadow-sm">
      <div class="container d-flex align-items-center gap-3">
        <span class="header__icon">🅿️</span>

        <div>
          <h1 class="header__title">
            Sistema de Parqueadero
          </h1>

          <p class="header__sub">
            Registro de Ingreso de Vehículos
          </p>
        </div>
      </div>
    </header>

    <!-- CONTENIDO -->
    <main class="container py-4 py-md-5">

      <div class="row justify-content-center">

        <div class="col-12 col-sm-10 col-md-8 col-lg-6">

          <!-- FORMULARIO -->
          <div
            v-if="!ticket"
            class="card shadow-lg border-0 rounded-4"
          >
            <div class="card-body p-3 p-md-4">

              <h2 class="text-center fw-bold mb-4">
                Registrar Ingreso
              </h2>

              <!-- PLACA -->
              <div class="mb-4">

                <label class="form-label fw-semibold">
                  Placa del vehículo *
                </label>

                <div class="d-flex flex-column flex-sm-row gap-2">

                  <input
                    v-model="plate"
                    type="text"
                    class="form-control"
                    :class="{ 'is-invalid': plateError }"
                    placeholder="Ej: ABC123"
                    maxlength="10"
                    @input="plate = plate.toUpperCase(); onPlateChange()"
                    @keyup.enter="lookupVehicle"
                  />

                  <button
                    class="btn btn-outline-primary"
                    :disabled="!plate || loadingVehicle"
                    @click="lookupVehicle"
                  >
                    <span
                      v-if="loadingVehicle"
                      class="spinner-border spinner-border-sm"
                    ></span>

                    <span v-else>
                      Buscar
                    </span>
                  </button>

                </div>

                <div class="invalid-feedback d-block" v-if="plateError">
                  {{ plateError }}
                </div>

              </div>

              <!-- VEHÍCULO ENCONTRADO -->
              <div
                v-if="vehicleFound && vehicleFound.id"
                class="alert alert-success d-flex align-items-center gap-3"
              >
                <i class="bi bi-car-front-fill fs-4"></i>

                <div>
                  <div class="fw-bold">
                    {{ vehicleFound.licensePlate }}
                  </div>

                  <small>
                    {{ vehicleFound.vehicleTypeName }}
                  </small>
                </div>

                <span class="badge bg-success ms-auto">
                  Registrado
                </span>
              </div>

              <!-- VEHÍCULO NUEVO -->
              <div
                v-if="plateSearched && !(vehicleFound && vehicleFound.id)"
                class="alert alert-warning d-flex align-items-center gap-3"
              >
                <i class="bi bi-exclamation-circle-fill"></i>

                <div>
                  Placa no registrada.
                  Se creará automáticamente al ingresar.
                </div>
              </div>

              <!-- TIPO VEHÍCULO -->
              <div
                v-if="plateSearched && !vehicleFound"
                class="mb-4"
              >
                <label class="form-label fw-semibold">
                  Tipo de vehículo *
                </label>

                <select
                  v-model="selectedVehicleTypeId"
                  class="form-select"
                  :class="{ 'is-invalid': vehicleTypeError }"
                >
                  <option value="" disabled>
                    {{
                      loadingTypes
                        ? 'Cargando tipos...'
                        : 'Selecciona el tipo'
                    }}
                  </option>

                  <option
                    v-for="vt in vehicleTypes"
                    :key="vt.id"
                    :value="vt.id"
                  >
                    {{ vt.name }}
                  </option>

                </select>

                <div
                  class="invalid-feedback d-block"
                  v-if="vehicleTypeError"
                >
                  {{ vehicleTypeError }}
                </div>

              </div>

              <!-- CELDAS -->
              <div v-if="plateSearched" class="mb-4">

                <label class="form-label fw-semibold">
                  Celda disponible *
                </label>

                <!-- LOADING -->
                <div v-if="loadingCells" class="text-center py-3">

                  <div
                    class="spinner-border text-primary"
                    role="status"
                  ></div>

                </div>

                <!-- SELECT -->
                <select
                  v-else
                  v-model="selectedCell"
                  class="form-select"
                  :class="{ 'is-invalid': cellError }"
                >
                  <option :value="null" disabled>
                    Selecciona una celda
                  </option>

                  <option
                    v-for="cell in availableCells"
                    :key="cell.id"
                    :value="cell"
                  >
                    {{ cell.name ?? cell.id }}
                  </option>

                </select>

                <!-- SIN CELDAS -->
                <div
                  v-if="availableCells.length === 0 && !loadingCells"
                  class="alert alert-warning mt-3"
                >
                  No hay celdas disponibles actualmente.
                </div>

                <!-- ERROR -->
                <div
                  class="invalid-feedback d-block"
                  v-if="cellError"
                >
                  {{ cellError }}
                </div>

              </div>

              <!-- ERROR API -->
              <div
                v-if="apiError"
                class="alert alert-danger d-flex align-items-center gap-2"
              >
                <i class="bi bi-exclamation-triangle-fill"></i>

                {{ apiError }}
              </div>

              <!-- BOTÓN -->
              <button
                v-if="plateSearched"
                class="btn btn-primary w-100 py-2 fw-semibold"
                :disabled="!canSubmit || loadingSubmit"
                @click="submitEntry"
              >

                <span
                  v-if="loadingSubmit"
                  class="spinner-border spinner-border-sm me-2"
                ></span>

                {{
                  loadingSubmit
                    ? 'Registrando ingreso...'
                    : 'Registrar Ingreso'
                }}

              </button>

            </div>
          </div>

          <!-- TICKET -->
          <div v-else class="d-flex flex-column gap-3">

            <div
              class="alert alert-success text-center fw-semibold"
            >
              ✅ Ingreso registrado exitosamente
            </div>

            <TicketCard
              :ticket="ticket"
              :license-plate="plate"
              :vehicle-type-name="currentVehicleTypeName"
              :cell-name="selectedCell.name"
            />

            <button
              class="btn btn-outline-primary"
              @click="reset"
            >
              Registrar otro vehículo
            </button>

          </div>

        </div>

      </div>

    </main>

  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'

import { useToast } from 'vue-toastification'

import {
  findVehicleByPlate,
  fetchVehicleTypes,
  fetchAvailableCells,
  registerEntry
} from '../api/parkingApi.js'

import TicketCard from '../components/cards/TicketCard.vue'

const toast = useToast()

// ESTADO
const plate = ref('')
const vehicleFound = ref(null)
const plateSearched = ref(false)

const vehicleTypes = ref([])
const availableCells = ref([])

const selectedVehicleTypeId = ref('')
const selectedCell = ref(null)

const ticket = ref(null)

// LOADING
const loadingVehicle = ref(false)
const loadingTypes = ref(false)
const loadingCells = ref(false)
const loadingSubmit = ref(false)

// ERRORES
const plateError = ref('')
const vehicleTypeError = ref('')
const cellError = ref('')
const apiError = ref('')

// COMPUTED
const canSubmit = computed(() => {

  const hasType =
    (vehicleFound.value && vehicleFound.value.id)
      ? true
      : !!selectedVehicleTypeId.value

  return hasType && selectedCell.value !== null
})

const currentVehicleTypeName = computed(() => {

  if (vehicleFound.value) {
    return vehicleFound.value.vehicleTypeName
  }

  const found = vehicleTypes.value.find(
    vt => vt.id === selectedVehicleTypeId.value
  )

  return found ? found.name : ''
})

const resolvedVehicleTypeId = computed(() =>

  (vehicleFound.value && vehicleFound.value.id)
    ? vehicleFound.value.vehicleTypeId
    : selectedVehicleTypeId.value
)

// LIFECYCLE
onMounted(async () => {

  await Promise.all([
    loadVehicleTypes(),
    loadCells()
  ])
})

// MÉTODOS
const onPlateChange = () => {

  vehicleFound.value = null
  plateSearched.value = false

  selectedCell.value = null
  selectedVehicleTypeId.value = ''

  plateError.value = ''
  apiError.value = ''
}

const lookupVehicle = async () => {

  plateError.value = ''
  apiError.value = ''

  if (!plate.value || plate.value.length < 5) {

    plateError.value =
      'La placa debe tener al menos 5 caracteres'

    return
  }

  loadingVehicle.value = true

  try {

    vehicleFound.value =
      await findVehicleByPlate(plate.value)

    plateSearched.value = true

    await loadCells()

  } catch {

    apiError.value =
      'Error al buscar el vehículo.'

    toast.error('Error al buscar el vehículo')

  } finally {

    loadingVehicle.value = false
  }
}

const loadVehicleTypes = async () => {

  loadingTypes.value = true

  try {

    vehicleTypes.value =
      await fetchVehicleTypes()

  } catch {

    apiError.value =
      'Error al cargar tipos de vehículo.'

    toast.error('Error al cargar tipos')

  } finally {

    loadingTypes.value = false
  }
}

const loadCells = async () => {

  loadingCells.value = true

  try {

    availableCells.value =
      await fetchAvailableCells()

  } catch {

    apiError.value =
      'Error al cargar las celdas.'

    toast.error('Error al cargar celdas')

  } finally {

    loadingCells.value = false
  }
}

const submitEntry = async () => {

  vehicleTypeError.value = ''
  cellError.value = ''
  apiError.value = ''

  if (!resolvedVehicleTypeId.value) {

    vehicleTypeError.value =
      'Selecciona el tipo de vehículo'

    return
  }

  if (!selectedCell.value) {

    cellError.value =
      'Selecciona una celda'

    return
  }

  const confirmed = confirm(
    '¿Deseas registrar el ingreso del vehículo?'
  )

  if (!confirmed) return

  loadingSubmit.value = true

  try {

    const payload = {

      ticketNumber:
        Math.floor(Math.random() * 9000) + 1000,

      entryDate: new Date(
        Date.now() - new Date().getTimezoneOffset() * 60000
      ).toISOString().slice(0, 19),

      licensePlate: plate.value,

      vehicleTypeId:
        resolvedVehicleTypeId.value,

      cellId:
        selectedCell.value.id,

      ticketStatus:
        import.meta.env.VITE_TICKET_STATUS_OPEN
    }

    ticket.value =
      await registerEntry(payload)

    toast.success(
      'Ingreso registrado exitosamente'
    )

  } catch (err) {

    apiError.value =
      err.response?.data?.detail
      ?? 'Error al registrar ingreso.'

    toast.error('Error al registrar ingreso')

  } finally {

    loadingSubmit.value = false
  }
}

const reset = async () => {

  plate.value = ''
  vehicleFound.value = null
  plateSearched.value = false

  selectedVehicleTypeId.value = ''
  selectedCell.value = null

  ticket.value = null
  apiError.value = ''

  await loadCells()
}
</script>

<style scoped>
.page {
  min-height: 100vh;
  background: #f8fafc;
}

.header {
  background: linear-gradient(
    135deg,
    #1e3a8a,
    #2563eb
  );

  color: white;
  padding: 1.25rem 0;
}

.header__icon {
  font-size: 2rem;
}

.header__title {
  margin: 0;
  font-size: 1.3rem;
  font-weight: 700;
}

.header__sub {
  margin: 0;
  opacity: 0.85;
  font-size: 0.9rem;
}

.card,
.alert,
.btn,
.form-control,
.form-select {
  transition: all 0.2s ease;
}

.card:hover {
  transform: translateY(-2px);
}

.form-control,
.form-select {
  border-radius: 12px;
  padding: 0.8rem 1rem;
}

.btn {
  border-radius: 12px;
  min-height: 48px;
}

.btn:hover {
  transform: translateY(-1px);
}

input,
select,
button {
  min-height: 48px;
}

.alert {
  border-radius: 12px;
}

@media (max-width: 576px) {

  .header__title {
    font-size: 1.1rem;
  }

  .header__sub {
    font-size: 0.75rem;
  }

  .header__icon {
    font-size: 1.5rem;
  }
}
</style>