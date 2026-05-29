<template>
  <div class="ticket">

    <div class="ticket__header">

      <div class="ticket__logo">
        🅿️
      </div>

      <div>
        <h2 class="ticket__title">
          Ticket de Ingreso
        </h2>

        <p class="ticket__subtitle">
          Sistema de Parqueadero
        </p>
      </div>

    </div>

    <div class="ticket__divider"></div>

    <div class="ticket__body">

      <div class="ticket__field">
        <span class="ticket__label">
          N° Ticket
        </span>

        <span class="ticket__value ticket__value--highlight">
          {{ ticket.ticketNumber }}
        </span>
      </div>

      <div class="ticket__field">
        <span class="ticket__label">
          Hora de Ingreso
        </span>

        <span class="ticket__value">
          {{ formatDateTime(ticket.entryDate) }}
        </span>
      </div>

      <div class="ticket__field">
        <span class="ticket__label">
          Placa
        </span>

        <span class="ticket__value ticket__value--plate">
          {{ licensePlate }}
        </span>
      </div>

      <div class="ticket__field">
        <span class="ticket__label">
          Tipo de Vehículo
        </span>

        <span class="ticket__value">
          {{ vehicleTypeName }}
        </span>
      </div>

      <div class="ticket__field">
        <span class="ticket__label">
          Celda Asignada
        </span>

        <span class="ticket__value ticket__value--cell">
          {{ cellName }}
        </span>
      </div>

    </div>

    <div class="ticket__divider ticket__divider--dashed"></div>

    <div class="ticket__footer">

      <span class="ticket__status">
        ● ABIERTO
      </span>

      <p>
        Conserve este ticket para la salida
      </p>

    </div>

  </div>
</template>

<script setup>
defineProps({
  ticket: { type: Object, required: true },
  licensePlate: { type: String, required: true },
  vehicleTypeName: { type: String, required: true },
  cellName: { type: String, required: true }
})

const formatDateTime = (iso) =>
  new Date(iso).toLocaleString('es-CO', {
    dateStyle: 'medium',
    timeStyle: 'short'
  })
</script>

<style scoped>
.ticket {
  background: white;
  border-radius: 16px;
  width: 100%;
  max-width: 420px;
  margin: 0 auto;
  box-shadow: 0 8px 32px rgba(0,0,0,0.12);
  overflow: hidden;
}

.ticket__header {
  background: linear-gradient(
    135deg,
    #1a3a5c,
    #2563eb
  );

  color: white;
  padding: 1.5rem;

  display: flex;
  align-items: center;
  gap: 1rem;
}

.ticket__logo {
  font-size: 2rem;
}

.ticket__title {
  margin: 0;
  font-size: 1.1rem;
  font-weight: 700;
}

.ticket__subtitle {
  margin: 0;
  font-size: 0.75rem;
  opacity: 0.8;
}

.ticket__divider {
  height: 1px;
  background: #e2e8f0;
  margin: 0 1.5rem;
}

.ticket__divider--dashed {
  border: none;
  border-top: 2px dashed #cbd5e1;
  background: none;
  height: 0;
}

.ticket__body {
  padding: 1.25rem 1.5rem;

  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.ticket__field {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  gap: 0.3rem;
}

.ticket__label {
  color: #64748b;
  font-size: 0.85rem;
}

.ticket__value {
  font-weight: 600;
  color: #1e293b;
}

.ticket__value--highlight {
  color: #2563eb;
  font-family: monospace;
  font-size: 1rem;
}

.ticket__value--plate {
  font-family: monospace;
  letter-spacing: 3px;
  font-size: 1rem;
}

.ticket__value--cell {
  background: #dbeafe;
  color: #1d4ed8;
  padding: 0.2rem 0.75rem;
  border-radius: 999px;
  font-family: monospace;
}

.ticket__footer {
  padding: 1rem 1.5rem;
  background: #f8fafc;

  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 1rem;
  flex-wrap: wrap;
}

.ticket__status {
  color: #16a34a;
  font-weight: 700;
  font-size: 0.85rem;
}

.ticket__footer p {
  color: #94a3b8;
  font-size: 0.75rem;
  margin: 0;
}

@media (max-width: 576px) {

  .ticket__header {
    padding: 1rem;
  }

  .ticket__body {
    padding: 1rem;
  }

  .ticket__footer {
    padding: 1rem;
  }

  .ticket__title {
    font-size: 1rem;
  }

  .ticket__value--plate {
    letter-spacing: 2px;
  }
}
</style>