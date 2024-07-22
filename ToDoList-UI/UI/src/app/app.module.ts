import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';

import { UserListComponent } from './user-list/user-list.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserDeleteComponent } from './user-delete/user-delete.component';
import { UserSingupComponent } from './user-signup/user-signup.component';
import { MainDashboardComponent } from './main-dashboard/main-dashboard.component';
import { UserPasswordChangeComponent } from './user-password-change/user-password-change.component';
import { UserListNameComponent } from './user-list-name/user-list-name.component';
import { TaskListComponent } from './task-list/task-list.component';
import { UserGetByIdComponent } from './user-get-by-id/user-get-by-id.component';
import { TaskDeleteComponent } from './task-delete/task-delete.component';
import { TaskUpdateComponent } from './task-update/task-update.component';
import { TaskUpdateStatusComponent } from './task-update-status/task-update-status.component';
import { TaskAddComponent } from './task-add/task-add.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserLoginComponent,
    UserDeleteComponent,
    UserSingupComponent,
    MainDashboardComponent,
    UserPasswordChangeComponent,
    UserListNameComponent,
    TaskListComponent,
    UserGetByIdComponent,
    TaskDeleteComponent,
    TaskUpdateComponent,
    TaskUpdateStatusComponent,
    TaskAddComponent,
    ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
