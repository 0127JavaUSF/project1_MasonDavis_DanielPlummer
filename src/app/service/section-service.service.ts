import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SectionServiceService {

  private sectionSubject = new Subject();
  public sectionObservable$ = this.sectionSubject.asObservable();

  divSets: number[] = [];

  constructor() { }


}
