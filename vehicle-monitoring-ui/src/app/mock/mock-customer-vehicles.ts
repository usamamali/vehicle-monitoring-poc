import { Customer } from '../beans/Customer';

export const CUSTOMERS: Customer[] = [
  {
    id: 1,
    name: 'Kalles Grustransporter AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: [
      {
        id: 'YS2R4X20005399401',
        registrationNumber: 'ABC123',
        status: 'Connected'
      },
      {
        id: 'VLUR4X20009093588',
        registrationNumber: 'DEF456',
        status: 'Disconnected'
      },
      {
        id: 'VLUR4X20009048066',
        registrationNumber: 'GHI789',
        status: 'Disconnected'
      }
    ]
  },
  {
    id: 2,
    name: 'Johans Bulk AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: [
      {
        id: 'YS2R4X20005388011',
        registrationNumber: 'JKL012',
        status: 'Disconnected'
      },
      {
        id: 'YS2R4X20005387949',
        registrationNumber: 'MNO345',
        status: 'Connected'
      }
    ]
  },
  {
    id: 3,
    name: 'Haralds Värdetransporter AB',
    address: 'Budgetvägen 1, 333 33 Uppsala',
    vehicles: [
      {
        id: 'VLUR4X20009048067',
        registrationNumber: 'PQR678',
        status: 'Connected'
      },
      {
        id: 'YS2R4X20005387055',
        registrationNumber: 'STU901',
        status: 'Connected'
      }
    ]
  },
  {
    id: 4,
    name: 'Kalles Grustransporter AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: []
  },
  {
    id: 5,
    name: 'Johans Bulk AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: []
  },
  {
    id: 6,
    name: 'Haralds Värdetransporter AB',
    address: 'Budgetvägen 1, 333 33 Uppsala',
    vehicles: []
  },
  {
    id: 7,
    name: 'Kalles Grustransporter AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: []
  },
  {
    id: 8,
    name: 'Johans Bulk AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: []
  },
  {
    id: 9,
    name: 'Haralds Värdetransporter AB',
    address: 'Budgetvägen 1, 333 33 Uppsala',
    vehicles: []
  },
  {
    id: 10,
    name: 'Kalles Grustransporter AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: []
  },
  {
    id: 11,
    name: 'Johans Bulk AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: []
  },
  {
    id: 12,
    name: 'Haralds Värdetransporter AB',
    address: 'Budgetvägen 1, 333 33 Uppsala',
    vehicles: []
  }
];
