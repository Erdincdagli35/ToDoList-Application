import { Component } from '@angular/core';

import { Router} from '@angular/router';
import { UserService } from '../user-service/user-service';
import { User } from 'src/app/models/user';


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {

    user: User = new User();
    errorMessage: string = '';
  
    private currentUserName : string = "";

    constructor(private userService: UserService, private router: Router) { }
  
    ngOnInit(): void {
    }
    
    login() {
      this.userService.login(this.user).subscribe(
        data => {
          this.currentUserName = this.user.userName;
          this.userService.setUserName(this.currentUserName);
          console.log("currentUsernma : " + this.currentUserName);
          // Giriş başarılı olduğunda ana sayfaya yönlendirme
          this.goToMain();
        },
        error => {
          console.error("Login error: ", error);
          // Giriş hatası olduğunda bir hata mesajı gösterme
          //alert("Login failed: " + error.message);
        }
      );
    }
    
    goToMain() {
      this.router.navigate(['/main-dashboard']); 
    }
    
    onSubmit() {
      console.log(this.user);
      this.login();
    }
}
