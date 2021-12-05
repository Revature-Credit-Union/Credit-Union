import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FrontDoorComponent } from './components/front-door/front-door.component';

const routes: Routes = [
  {path: '', redirectTo: '/front-door', pathMatch: 'full'},
  {path: 'front-door', component: FrontDoorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
