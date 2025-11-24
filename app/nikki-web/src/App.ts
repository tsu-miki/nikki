import { LitElement, html } from 'lit'
import { customElement } from 'lit/decorators.js'

@customElement('app-root')
export class App extends LitElement {
  render() {
    return html`<h1>日記</h1>`
  }
}

declare global {
  interface HTMLElementTagNameMap {
    'app-root': App
  }
}
