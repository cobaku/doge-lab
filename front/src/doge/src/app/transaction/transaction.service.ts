import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Transaction} from "./transaction";
import {Observable} from "rxjs";

@Injectable({
	providedIn: 'root'
})
export class TransactionService {

	constructor(private http: HttpClient) {
	}

	public getTransaction(id: string): Observable<Transaction> {
		return this.http.get<Transaction>("http://localhost:8080/chain/block/" + id);
	}
}
