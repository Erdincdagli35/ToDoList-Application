import { Component } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../user-service/user-service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-main-dashboard',
  templateUrl: './main-dashboard.component.html',
  styleUrls: ['./main-dashboard.component.css']
})
export class MainDashboardComponent {

  loggedUserName : string = "";

  user : User = new User();
  userTemp : User = new User();

    constructor(private userService : UserService, 
                private activatedRoute: ActivatedRoute, 
                private router: Router){}

    ngOnInit(): void {
      const currentUserName = this.userService.getUserName();
    const currentUserNameString: string = currentUserName.toString();
    console.log("currentUserNameString : " + currentUserNameString);
    this.loggedUserName = currentUserName;
    
    }
}
