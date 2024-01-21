/* eslint-disable react/prop-types */
import {createRoot} from 'react-dom/client'
import App from './components/App'
import { StrictMode } from 'react'


const root = createRoot(document.getElementById('root'))

root.render(
  <StrictMode>
    <App />
  </StrictMode>

) 
