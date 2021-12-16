import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';

/*to be used as "Can Activate" routing guard*/
@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private tokenStore: TokenStorageService, private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    if (this.isValidToken()) {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
  /* Curently checks if there is a token present.
  TODO- check if the token has not expired*/
  private isValidToken(): boolean {
    let token: string | null = this.tokenStore.getToken();
    if (!token) { //falsy value of token
      return false;
    }
    return true;
  }
}
