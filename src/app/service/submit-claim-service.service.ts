import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NewClaim } from '../classes/newClaim';

@Injectable({
  providedIn: 'root'
})
export class SubmitClaimServiceService {

  constructor(private http: HttpClient) {}

  url = 'http://localhost:8080/Project11/SubmitServlet';

  create(newClaim: NewClaim) {
    return this.http.post<any>(this.url , newClaim);
  }

}
