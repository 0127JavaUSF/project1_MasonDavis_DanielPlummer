import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SubmitClaimServiceService } from '../service/submit-claim-service.service';
import { NewClaim } from '../classes/newClaim';
@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent {

  reasons = ['Food', 'Lodging', 'Travel', 'Other'];

  constructor(private submitClaim: SubmitClaimServiceService) { }

  newClaim = new NewClaim(1, 'food', null);

  onSubmit() {
    this.submitClaim.create(this.newClaim)
    .subscribe(
      data => (console.log('Success')),
      error => (console.log('Error'))
    );
  }
}

