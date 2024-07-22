import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSingupComponent } from './user-signup.component';

describe('UserSingupComponent', () => {
  let component: UserSingupComponent;
  let fixture: ComponentFixture<UserSingupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserSingupComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserSingupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
