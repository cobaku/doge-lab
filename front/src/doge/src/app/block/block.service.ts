import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BlockInfo} from "./block-info";

@Injectable({
	providedIn: 'root'
})
export class BlockService {

	constructor(public http: HttpClient) {
	}

	public getBlock(identifier: any): Observable<BlockInfo> {
		return this.http.get<BlockInfo>("http://localhost:8080/chain/block/" + identifier);
	}
}
