import { Pipe, PipeTransform } from '@angular/core';
import { Vehicle } from '../beans/Vehicle';
@Pipe({
  name: 'vehiclefilter',
  pure: false
})
export class VehicleFilterPipe implements PipeTransform {
  transform(items: Vehicle[], filter: Vehicle): Vehicle[] {
    if (!items || !filter) {
      return items;
    }
    // filter items array, items which match and return true will be kept, false will be filtered out
    return items.filter((item: Vehicle) => this.applyFilter(item, filter));
  }

  applyFilter(vehicle: Vehicle, filter: Vehicle): boolean {
    if (filter.status) {
      if (vehicle.status !== filter.status && filter.status !== 'All') {
        return false;
      }
    }
    return true;
  }
}
