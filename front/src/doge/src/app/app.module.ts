import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
	MatButtonModule,
	MatCardModule, MatDialogModule,
	MatDividerModule,
	MatExpansionModule,
	MatFormFieldModule,
	MatInputModule,
	MatMenuModule,
	MatToolbarModule
} from "@angular/material";
import {RouterModule, Routes} from "@angular/router";
import {WalletComponent} from './wallet/wallet.component';
import {BlockComponent} from './block/block.component';
import {TransactionComponent} from './transaction/transaction.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BlockService} from "./block/block.service";
import {HttpClientModule} from "@angular/common/http";
import { BlockInfoComponent } from './block/block-info/block-info.component';

const routes: Routes = [
	{
		path: 'wallet',
		component: WalletComponent
	},
	{
		path: 'block',
		component: BlockComponent
	},
	{
		path: 'transaction',
		component: TransactionComponent
	},
	{
		path: '**',
		redirectTo: '/',
	},
];

@NgModule({
	declarations: [
		AppComponent,
		WalletComponent,
		BlockComponent,
		TransactionComponent,
		BlockInfoComponent
	],
	imports: [
		BrowserModule, BrowserAnimationsModule, RouterModule.forRoot(routes),
		MatMenuModule, MatToolbarModule, MatButtonModule,
		MatFormFieldModule, FormsModule, ReactiveFormsModule,
		MatInputModule, MatCardModule, MatExpansionModule,
		MatDividerModule, HttpClientModule, MatDialogModule
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule {
}
