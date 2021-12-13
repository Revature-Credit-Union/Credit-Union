import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from 'src/app/components/profile/profile.component';
import { UserProfileComponent } from 'src/app/components/user-profile/user-profile.component';
import { AccountSettingsComponent } from 'src/app/components/account-settings/account-settings.component';
import { SecurityProfileComponent } from 'src/app/security-profile/security-profile.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    ProfileComponent,
    UserProfileComponent,
    AccountSettingsComponent,
    SecurityProfileComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    //HttpClientModule,
    //RouterModule,
  ]
})
export class ProfileModule { }
