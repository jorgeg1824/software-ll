import axios from 'axios'

const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
  headers: { 'Content-Type': 'application/json' }
})

export const findVehicleByPlate = async (plate) => {
  try {
    const res = await api.get(`/vehicles/plate/${plate}`)
    return res.data
  } catch (err) {
    if (err.response?.status === 404) return null
    throw err
  }
}

export const fetchVehicleTypes = () =>
  api.get('/vehicles/types').then(res => res.data)

export const fetchAvailableCells = () =>
  api.get('/cells/available').then(res => res.data)

export const registerEntry = (payload) =>
  api.post('/tickets/entry', payload).then(res => res.data)