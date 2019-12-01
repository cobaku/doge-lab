export class BlockInfo {

	public valueIn: number;
	public valueOut: number;
	public previousBlockHash: string;
	public nextBlockHash: string;
	public averageCoinAge: number;
	public hash: string;
	public difficulty: number;
	public time: number;
	public confirmations: number;
	public merkleRoot: string;
	public txs: Array<string>;
	public version: number;
	public height: number;

}
