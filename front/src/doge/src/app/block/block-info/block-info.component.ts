import {Component, Input} from '@angular/core';
import {BlockInfo} from "../block-info";
import {MatDialog, MatDialogRef} from "@angular/material";
import {TransactionComponent} from "../../transaction/transaction.component";

@Component({
	selector: 'app-block-info',
	templateUrl: './block-info.component.html',
	styleUrls: ['./block-info.component.css']
})
export class BlockInfoComponent {

	@Input() block: BlockInfo;

	constructor(
		public dialog: MatDialog,
		public dialogRef: MatDialogRef<BlockInfoComponent>) {

	}

	public showTransaction(transaction: string): void {
		this.dialog.open(TransactionComponent, {
			data: transaction
		})
	}

	public showBlock(block: string): void {

	}
}
