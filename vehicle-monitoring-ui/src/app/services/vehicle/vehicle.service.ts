import { Injectable } from '@angular/core';
import { Vehicle } from '../../beans/Vehicle';
import { VEHICLES } from '../../mock/mock-vehicles';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  private vehiclesUrl = '/vehicle-api/api/vehicle';

  constructor(private http: HttpClient) {}

  /** GET vehicles from the server */
  getVehicles(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(this.vehiclesUrl).pipe(
      tap(_ => this.log('fetched vehicles')),
      catchError(this.handleError('getVehicles', []))
    );
  }

  getVehicle(id: string): Observable<Vehicle> {
    const url = `${this.vehiclesUrl}/${id}`;
    return this.http.get<Vehicle>(url).pipe(
      tap(_ => this.log(`fetched hero id=${id}`)),
      catchError(this.handleError<Vehicle>(`getVehicle id=${id}`))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }

  private log(message: string) {
    console.log(message);
  }
}
