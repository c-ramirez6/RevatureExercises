import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterpolationsComponent } from './interpolations.component';

describe('InterpolationsComponent', () => {
  let component: InterpolationsComponent;
  let fixture: ComponentFixture<InterpolationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterpolationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InterpolationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
