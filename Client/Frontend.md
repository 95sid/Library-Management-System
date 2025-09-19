# 📚 Library Management System – React + Vite

This is a **React + Vite** frontend for a Library Management System.  
It is powered by **Vite** for fast bundling, development, and production builds.  
It uses React 19, React Router v7, Axios for API calls, and is configured for deployment on Vercel.

## 🚀 Features
- Built with **React + Vite** for fast development and HMR
- **Vite** as the build tool for lightning-fast dev server and optimized production builds
- **React Router** for client-side routing
- **Axios** for HTTP requests
- ESLint configured with React Hooks & Vite Fast Refresh plugins
- Deployable on **Vercel** with automatic rewrite rules

## 🛠️ Tech Stack
- **React 19** + **Vite 7**
- **React Router 7**
- **Axios**
- **ESLint** for linting
- **Vercel** for hosting

## 📂 Project Structure
```
client/
├── public/           # static assets
├── src/              # React components, pages, hooks
├── index.html        # entry point
├── package.json      # scripts & dependencies
├── eslint.config.js  # ESLint rules
└── vercel.json       # Vercel rewrite config
```

## 🏗️ Installation & Setup

Clone the repository and install dependencies:

```bash
git clone <repo-url>
cd client
npm install
```

### Run Locally (Development with Vite)
```bash
npm run dev
```
This starts **Vite’s dev server** at [http://localhost:5173](http://localhost:5173) (or next available port).

### Lint Code
```bash
npm run lint
```

### Build for Production (Vite)
```bash
npm run build
```
The optimized Vite build will be output to the `dist/` folder.

### Preview Production Build
```bash
npm run preview
```
This serves the `dist/` folder locally for testing with **Vite preview**.

## 🌐 Deployment (Vercel)
The project is configured with a `vercel.json` file:

```json
{
  "rewrites": [
    { "source": "/(.*)", "destination": "/" }
  ]
}
```

This ensures that client-side routing works correctly in production.  
You can deploy by linking the repo to Vercel and it will automatically build & deploy using `npm run build`.

## ⚙️ Environment Variables
If your app needs API endpoints or secrets, create a `.env` file in the root and add:
```
VITE_API_URL=https://your-api-url
```
Use them in code with `import.meta.env.VITE_API_URL`.

---

### 📄 License
(Choose a license here if needed, e.g. MIT)

---
