import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface NewClaim {

  amount: number;
  type: string;
  receipt: Blob; // change in accordance with database


}

@Injectable({
  providedIn: 'root'
})
export class SubmitClaimServiceService {

  constructor(private httpClient: HttpClient) { }

  submit(input: string): Promise<NewClaim> {

    const url = 'http://localhost:8080/Project11/SubmitServlet';
    return this.httpClient.get<NewClaim>(url).toPromise();

  }
}
