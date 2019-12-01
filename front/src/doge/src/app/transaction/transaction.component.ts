import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material";

@Component({
	selector: 'app-transaction',
	templateUrl: './transaction.component.html',
	styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

	constructor(
		public dialogRef: MatDialogRef<TransactionComponent>
	) {
	}

	ngOnInit() {
	}

}
