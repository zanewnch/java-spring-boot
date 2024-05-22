import Cookies from 'js-cookie';

export default class CookieUtils{
    

    // Cookies.set('cookieName','cookieValue')
    static setToken(tokenName:string,token: string){
        Cookies.set(tokenName,token);
    }
    static getToken(tokenName:string):string{
        return Cookies.get(tokenName);
    }

    
}