import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  showButtons = true;

  constructor(private router: Router) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.checkRoute(event.url);
      }
    });
  }

  checkRoute(url: string): void {
    // Rotaya göre butonların gösterilip gösterilmeyeceğini belirleyin
    this.showButtons = !(url.includes('/user-login') || url.includes('/user-signup') || 
                        url.includes('main-dashboard') || url.includes('/user-list') || 
                        url.includes('/task-list') || url.includes('/task-add') );
  }
}
