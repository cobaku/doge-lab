import {Component, Inject, OnInit} from '@angular/core';
import {TransactionService} from "./transaction.service";
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {Transaction} from "./transaction";
import {WalletComponent} from "../wallet/wallet.component";

@Component({
	selector: 'app-transaction',
	templateUrl: './transaction.component.html',
	styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

	public transaction: Transaction;

	constructor(public transactionService: TransactionService,
				@Inject(MAT_DIALOG_DATA) public data: any,
				public dialog: MatDialog) {
	}

	ngOnInit() {
		this.transactionService.getTransaction(this.data).subscribe(t => this.transaction = t);
	}

	public showWallet(wallet: string) {
		this.dialog.open(WalletComponent, {
			data: wallet
		});
	}

}
