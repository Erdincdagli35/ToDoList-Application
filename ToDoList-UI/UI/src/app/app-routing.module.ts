import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UserLoginComponent } from './user-login/user-login.component';
import { UserSingupComponent } from './user-signup/user-signup.component';
import { MainDashboardComponent } from './main-dashboard/main-dashboard.component';
import { UserDeleteComponent } from './user-delete/user-delete.component';
import { UserPasswordChangeComponent } from './user-password-change/user-password-change.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserListNameComponent } from './user-list-name/user-list-name.component';
import { TaskListComponent } from './task-list/task-list.component';
import { UserGetByIdComponent } from './user-get-by-id/user-get-by-id.component';
import { TaskDeleteComponent } from './task-delete/task-delete.component';
import { TaskUpdateComponent } from './task-update/task-update.component';
import { TaskAddComponent } from './task-add/task-add.component';

const routes: Routes = [
  { path: '', redirectTo: 'user', pathMatch: 'full' },
  { path: 'user-list', component: UserListComponent },
  { path: 'user-login', component: UserLoginComponent },
  { path: 'user-signup', component: UserSingupComponent },
  { path: 'user-list-name/:name', component: UserListNameComponent },
  { path: 'user-list-by-id', component: UserGetByIdComponent },
  { path: 'user-delete/:id', component: UserDeleteComponent },
  { path: 'user-password-change', component: UserPasswordChangeComponent},

  //{ path: 'task-list', component: TaskListComponent},
  { path: 'task-list', component: TaskListComponent},
  { path: 'task-delete/:id', component: TaskDeleteComponent},
  { path: 'task-edit', component: TaskUpdateComponent},
  { path: 'task-add', component:TaskAddComponent},

  { path: 'main-dashboard', component: MainDashboardComponent},
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }