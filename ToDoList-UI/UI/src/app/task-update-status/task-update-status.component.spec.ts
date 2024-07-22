import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskUpdateStatusComponent } from './task-update-status.component';

describe('TaskUpdateStatusComponent', () => {
  let component: TaskUpdateStatusComponent;
  let fixture: ComponentFixture<TaskUpdateStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskUpdateStatusComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskUpdateStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
