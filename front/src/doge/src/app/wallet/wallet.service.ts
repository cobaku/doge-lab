import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Wallet} from "./wallet";

@Injectable({
	providedIn: 'root'
})
export class WalletService {

	constructor(private http: HttpClient) {
	}

	public getWallet(id: string): Observable<Wallet> {
		return this.http.get<Wallet>("http://localhost:8080/wallet/" + id);
	}
}
