export class Transaction {

	blockHash: string;
	outputsValue: number;
	inputsValue: number;
	hash: string;
	confirmations: number;
	size: number;
	time: number;
	fee: number;
	outputAddress: Array<Output>;
	inputAddress: Array<Input>;

}

export class Output {
	pos: number;
	value: number;
	type: string;
	address: string;
}

export class Input {
	sig: string;
	pos: number;
	value: number;
	address: string;
	type: string;
}
