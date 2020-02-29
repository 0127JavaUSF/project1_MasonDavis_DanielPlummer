import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface History {
  number: number;
  amount: number;
  reason: string;
  status: string;
  submitNumber: number; // might be string
  name: string;

}

@Injectable({
  providedIn: 'root'
})

export class HistoryServiceService {

  constructor(private httpClient: HttpClient) { }

  login(input: string): Promise<History> {

    const url = 'http://localhost:8080/Project11/SubmitServlet';
    return this.httpClient.get<History>(url).toPromise();

  }
}
