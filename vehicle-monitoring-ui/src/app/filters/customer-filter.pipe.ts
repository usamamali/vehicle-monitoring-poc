import { Pipe, PipeTransform } from '@angular/core';
import { Customer } from '../beans/Customer';
@Pipe({
  name: 'customerfilter',
  pure: false
})
export class CustomerFilterPipe implements PipeTransform {
  transform(items: Customer[], filter: Customer): Customer[] {
    if (!items || !filter) {
      return items;
    }
    return items.filter((item: Customer) => this.applyFilter(item, filter));
  }

  applyFilter(customer: Customer, filter: Customer): boolean {
    for (let field in filter) {
      if (filter[field]) {
        if (typeof filter[field] === 'string') {
          if (
            customer[field]
              .toLowerCase()
              .indexOf(filter[field].toLowerCase()) === -1
          ) {
            return false;
          }
        } else if (typeof filter[field] === 'number') {
          if (customer[field] !== filter[field]) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
