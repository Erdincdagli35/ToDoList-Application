import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { UserService } from '../user-service/user-service';
import { UserPasswordChangePojo } from '../models/UserPasswordChangePojo';

@Component({
  selector: 'app-user-password-change',
  templateUrl: './user-password-change.component.html',
  styleUrls: ['./user-password-change.component.css']
})
export class UserPasswordChangeComponent {

  userTemp : UserPasswordChangePojo = new UserPasswordChangePojo();
  user : UserPasswordChangePojo = new UserPasswordChangePojo();

    constructor(private userService : UserService, 
                private activetedRoute: ActivatedRoute, 
                private router: Router){}

    ngOnInit(): void {
     
    }

    onSubmit(){
       console.log("onSubmit : user : " + this.user.name);
      this.userService.passwordChange(this.user)
                         .subscribe(data => {
        console.log("updateuser");
        this.goToList();
      },
      error => console.log(error));
    }

    goToList() {
      this.router.navigate(['/main-dashboard']);
    }

}
