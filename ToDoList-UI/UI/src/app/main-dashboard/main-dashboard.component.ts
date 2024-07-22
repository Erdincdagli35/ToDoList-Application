import { Component } from '@angular/core';
import { UserService } from '../user-service/user-service';
import { User } from 'src/app/models/user';
import { Router} from '@angular/router';

@Component({
  selector: 'app-main-dashboard',
  templateUrl: './main-dashboard.component.html',
  styleUrls: ['./main-dashboard.component.css']
})
export class MainDashboardComponent {
  currentUserName : string = "";
  user: User = new User();

  constructor(private userService: UserService, private router: Router) { }
}
