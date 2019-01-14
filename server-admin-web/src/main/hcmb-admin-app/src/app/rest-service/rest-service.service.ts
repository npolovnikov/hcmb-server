import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

export const REST_OPTIONS: object = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Cache-Control': 'no-cache, no-store, must-revalidate',
    'Pragma': 'no-cache',
    'Expires': '0'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RestServiceService {

  constructor(private http: HttpClient) { }

  getPlayerList(filter: any) {
    return this.http.post<any>("/hcmb/admin/api/player/playerList", {
      nameFilter: "",
      countryFilter:"",
      ovrFilter: {min: 0, max:100},
      statsFilter: {key: {min: 1, max: 100}}
    }, REST_OPTIONS)
  }
}
