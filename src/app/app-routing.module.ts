import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserPageComponent} from 'src/app/user-page/user-page.component';
import {ManagerPageComponent} from 'src/app/manager-page/manager-page.component';
import {HistoryComponent} from 'src/app/history/history.component';
import { LoginPageComponent } from './login-page/login-page.component';

const routes: Routes = [{

  // set these up so it can move from page to page for the manager or user pages.

   component: HistoryComponent,
   path: 'history'
}, {
   component: UserPageComponent,
   path: 'newform'
}, {
   component: ManagerPageComponent,
   path: 'reviews'
}, {
  component: LoginPageComponent,
  path: 'login'
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
 }
