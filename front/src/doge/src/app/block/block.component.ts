import {Component, OnInit} from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {BlockInfo} from "./block-info";
import {BlockService} from "./block.service";

@Component({
	selector: 'app-block',
	templateUrl: './block.component.html',
	styleUrls: ['./block.component.css'],
	providers: [BlockService]
})
export class BlockComponent implements OnInit {

	public blockId: any;
	public block: BlockInfo;

	blockFormControl = new FormControl('', [
		Validators.required
	]);

	constructor(private blockService: BlockService) {
	}

	ngOnInit() {
	}

	public getBlock(): void {
		this.blockService.getBlock(this.blockId)
			.subscribe(b => {
				this.block = b;
			})
	}
}
