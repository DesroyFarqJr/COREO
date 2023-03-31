declare module 'vue3-google-oauth2' {
    import type App from 'vue';
    import type  Plugin from 'vue';

  
    export interface GAuthOptions {
      clientId: string
      scope?: string
      prompt?: string
      fetchBasicProfile?: boolean
      cookiePolicy?: string
      hostedDomain?: string
      discoveryDocs?: string[]
      uxMode?: string
      redirectUri?: string
    }
  
    export interface GAuth {
      readonly isAuthorized: boolean
      readonly currentUser: any
      readonly authCode: string | null
  
      login(): Promise<void>
      logout(): Promise<void>
      getAuthCode(): Promise<void>
    }
  
    export function createGAuth(app: App, options: GAuthOptions): GAuth
    export const GAuthPlugin: Plugin
  }
  