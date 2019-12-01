import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {WalletService} from "./wallet.service";
import {Wallet} from "./wallet";

@Component({
	selector: 'app-wallet',
	templateUrl: './wallet.component.html',
	styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {

	public wallet: Wallet;

	constructor(@Inject(MAT_DIALOG_DATA) public data: any,
				public walletService: WalletService) {
	}

	ngOnInit() {
		this.walletService.getWallet(this.data).subscribe(w => this.wallet = w);
	}

}
