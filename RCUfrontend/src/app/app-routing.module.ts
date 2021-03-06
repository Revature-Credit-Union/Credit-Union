import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';



import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
//import { ProfileComponent } from './components/profile/profile.component';
import { BoardUserComponent } from './components/board-user/board-user.component';
import { BoardModeratorComponent } from './components/board-moderator/board-moderator.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { AccountSettingsComponent } from './components/account-settings/account-settings.component';
import { SecurityProfileComponent } from './security-profile/security-profile.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';

import { ProfileComponent } from './components/profile/profile.component';

import { TransferComponent } from './components/transfer/transfer.component';
import { TransactionSummaryComponent } from './components/transaction-summary/transaction-summary.component';
import { DepositWithdrawComponent } from './components/deposit-withdraw/deposit-withdraw.component';
import { AccountsComponent } from './components/accounts/accounts.component';



const routes: Routes = [
  {path: '', redirectTo: '/front-door', pathMatch: 'full'},
    //{ path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  {path: 'user-profile', component: UserProfileComponent},
  {path: 'change-password', component: ChangePasswordComponent},
  {path: 'security-profile', component: SecurityProfileComponent},
  { path: 'settings', component: AccountSettingsComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: "summary", component: TransactionSummaryComponent},
  { path: "deposit-withdraw", component: DepositWithdrawComponent},
  { path: "accounts", component: AccountsComponent},
  {path: "change-password", component: ChangePasswordComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
