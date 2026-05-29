import { ref, computed } from 'vue'
import {
  findVehicleByPlate,
  fetchVehicleTypes,
  fetchAvailableCells,
  registerEntry
} from '../api/parkingApi'

export function useEntryForm() {

  const plate = ref('')
  const vehicleFound = ref(null)
  const plateSearched = ref(false)
  const vehicleTypes = ref([])
  const availableCells = ref([])
  const selectedVehicleTypeId = ref('')
  const selectedCell = ref(null)
  const ticket = ref(null)

  const loading = ref(false)
  const error = ref('')

  const canSubmit = computed(() => {
    const hasType = vehicleFound.value
      ? true
      : !!selectedVehicleTypeId.value

    return hasType && selectedCell.value
  })

  return {
    plate,
    vehicleFound,
    plateSearched,
    vehicleTypes,
    availableCells,
    selectedVehicleTypeId,
    selectedCell,
    ticket,
    loading,
    error,
    canSubmit
  }
}