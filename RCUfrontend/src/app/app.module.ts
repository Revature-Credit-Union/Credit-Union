import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';



import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';

import { SecurityProfileComponent } from './security-profile/security-profile.component';
//import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { AuthInterceptor } from './helpers/auth.interceptor';
import { ProfileModule } from './modules/profile/profile.module';
import { TransferComponent } from './components/transfer/transfer.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { DepositWithdrawComponent } from './components/deposit-withdraw/deposit-withdraw.component';
import { TransactionSummaryComponent } from './components/transaction-summary/transaction-summary.component';


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    TransferComponent,
    ChangePasswordComponent,
    DepositWithdrawComponent,
    TransactionSummaryComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    CommonModule,
    ProfileModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
