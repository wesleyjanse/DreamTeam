import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule, MatIconModule, MatSidenavModule, 
         MatListModule, MatButtonModule, MatCardModule, MatGridListModule, 
         MatBadgeModule, MatProgressSpinnerModule, MatExpansionModule,
         MatSlideToggleModule, MatTooltipModule, MatStepperModule, MatDialogModule,
         MatAutocompleteModule, MatChipsModule, MatSnackBarModule, MatTabsModule } from  '@angular/material';


@NgModule({
  imports: [
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatGridListModule,
    MatBadgeModule,
    MatProgressSpinnerModule,
    MatExpansionModule,
    MatSlideToggleModule,
    MatTooltipModule,
    MatStepperModule,
    MatDialogModule,
    MatAutocompleteModule,
    MatChipsModule,
    MatSnackBarModule,
    MatTabsModule
  ],
  exports: [
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatIconModule, 
    MatCardModule,
    MatGridListModule,
    MatBadgeModule,
    MatProgressSpinnerModule,
    MatExpansionModule,
    MatSlideToggleModule,
    MatTooltipModule,
    MatStepperModule,
    MatDialogModule,
    MatAutocompleteModule,
    MatChipsModule,
    MatSnackBarModule,
    MatTabsModule
  ]
})
export class MaterialModule { }
