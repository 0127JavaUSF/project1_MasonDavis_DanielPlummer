import { Component, OnInit } from '@angular/core';
import { SubmitClaimServiceService } from '../service/submit-claim-service.service';
import { NewClaim } from '../classes/newClaim';
@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent {
  // setting the options for reimburesments
  reasons = ['Food', 'Lodging', 'Travel', 'Other'];

  constructor(private submitClaim: SubmitClaimServiceService) { }

  newClaim = new NewClaim(0, 'Food', null);

  onSubmit() {
    this.submitClaim.create(this.newClaim)
    .subscribe(
      data => (console.log('Success')),
      error => (console.log('Error'))
    );
  }
}
