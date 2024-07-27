import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { MainDashboardComponent } from './main-dashboard/main-dashboard.component';

import { UserLoginComponent } from './user-login/user-login.component';
import { UserSingupComponent } from './user-signup/user-signup.component';
import { UserDeleteComponent } from './user-delete/user-delete.component';
import { UserPasswordChangeComponent } from './user-password-change/user-password-change.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserListNameComponent } from './user-list-name/user-list-name.component';
import { UserGetByIdComponent } from './user-get-by-id/user-get-by-id.component';

import { TaskListComponent } from './task-list/task-list.component';
import { TaskDeleteComponent } from './task-delete/task-delete.component';
import { TaskUpdateComponent } from './task-update/task-update.component';
import { TaskAddComponent } from './task-add/task-add.component';
import { TaskListAllAdminComponent } from './task-list-all-admin/task-list-all-admin.component';

const routes: Routes = [
  { path: '', redirectTo: 'user', pathMatch: 'full' },
  { path: 'user-list', component: UserListComponent },
  { path: 'user-login', component: UserLoginComponent },
  { path: 'user-signup', component: UserSingupComponent },
  { path: 'user-list-name/:name', component: UserListNameComponent },
  { path: 'user-list-by-id', component: UserGetByIdComponent },
  { path: 'user-delete/:id', component: UserDeleteComponent },
  { path: 'user-password-change/:userName', component: UserPasswordChangeComponent},

  { path: 'task-list', component: TaskListAllAdminComponent},
  { path: 'task-list-by-user', component: TaskListComponent},
  { path: 'task-delete/:id', component: TaskDeleteComponent},
  { path: 'task-edit/:id', component: TaskUpdateComponent},
  { path: 'task-add', component:TaskAddComponent},

  { path: 'main-dashboard', component: MainDashboardComponent},
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }