import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material";

@Component({
	selector: 'app-wallet',
	templateUrl: './wallet.component.html',
	styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {

	constructor(
		public dialogRef: MatDialogRef<WalletComponent>
	) {
	}

	ngOnInit() {
	}

}
