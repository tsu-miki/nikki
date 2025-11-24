# nikki-web

Lit + TypeScript + Vite (Rolldown) で構築された日記アプリ

## 🎯 プロジェクト概要

このプロジェクトは、Layer型とFeature型のハイブリッドアーキテクチャを採用した、Web Componentsベースのアプリケーションです。

### 技術スタック

- **フレームワーク**: [Lit](https://lit.dev/)
- **言語**: TypeScript
- **ビルドツール**: Vite (Rolldown)
- **アーキテクチャ**: Layer型 × Feature型のハイブリッド構成

## 📁 ディレクトリ構成

```
src/
├── assets/            # 画像、フォントなどの静的リソース
├── components/        # アプリ全体で共有する汎用UIパーツ
│   ├── ui/            # デザインシステムの基本要素（Button, Input等）
│   └── model/         # データモデルに紐づく共通コンポーネント
├── config/            # 環境変数や定数設定
├── features/          # ★機能ごとのドメイン領域（核心部分）
│   ├── auth/          # 認証機能
│   ├── diary/         # 日記機能
│   └── users/         # ユーザー管理機能
├── lib/               # 外部ライブラリの設定
├── providers/         # DI設定やContextの初期化
├── routes/            # ルーティング設定
├── stores/            # グローバルな状態管理
├── styles/            # 共有CSS変数（Design Tokens）、リセットCSS
├── types/             # アプリ全体で共有する型定義
├── utils/             # 純粋なヘルパー関数
├── App.ts             # ルートコンポーネント
└── main.ts            # エントリーポイント
```

## 🚀 セットアップ

### 必要な環境

- Node.js 18.x 以上
- pnpm 8.x 以上

### インストール

```bash
pnpm install
```

### 開発サーバーの起動

```bash
pnpm dev
```

ブラウザで http://localhost:3000 を開きます。

### ビルド

```bash
pnpm build
```

### プレビュー

```bash
pnpm preview
```

## 🏗️ アーキテクチャの特徴

### Layer型とFeature型のハイブリッド

このプロジェクトは、2つの分割方向を組み合わせています：

#### Feature型（機能別）- 基本方針
- 機能ごとに独立したディレクトリ構成
- 高凝集・疎結合を実現
- 影響範囲を限定し、開発しやすさを向上

#### Layer型（技術別）- 共通化の整理
- 共通UIコンポーネント
- ユーティリティ関数
- 型定義
- 依存関係の方向を整理

### 依存関係のルール

```
features/[feature] 
  ↓ 依存OK
components/ui, components/model, utils, types, lib, stores

features/A → features/B  ❌ 禁止
components → features/   ❌ 禁止
utils → components/      ❌ 禁止
```

## 📝 開発ガイドライン

詳細な実装ルールは `.cursorrules` ファイルを参照してください。

### 新機能の追加手順

1. **featureディレクトリの作成**
   ```bash
   mkdir -p src/features/[feature-name]/{api,components,controllers,types}
   ```

2. **index.tsの作成**（公開APIの定義）

3. **型定義の作成**（`types/index.ts`）

4. **コンポーネントの実装**（`components/`）

5. **ロジックの実装**（`controllers/`や`api/`）

6. **App.tsへの統合**

### コンポーネントの命名規則

カスタム要素名は必ずケバブケースで、プレフィックスを付けます：

- `ui-*`: 共通UIコンポーネント（例: `ui-button`, `ui-modal`）
- `diary-*`: 日記機能（例: `diary-entry`, `diary-list`）
- `app-*`: アプリケーションレベル（例: `app-header`, `app-root`）

```typescript
// Good ✅
@customElement('diary-entry-form')
export class DiaryEntryForm extends LitElement { }

// Bad ❌
@customElement('diaryForm')  // ケバブケースではない
@customElement('form')        // プレフィックスがない
```

### ファイル・クラス命名規則

- **ファイル名**: PascalCase（例: `DiaryEntry.ts`, `Button.ts`）
- **クラス名**: PascalCase（例: `DiaryEntry`, `Button`）
- **Controller**: `*Controller.ts`（例: `DiaryController.ts`）
- **API**: `*Api.ts`（例: `diaryApi.ts`）

## 🎨 スタイリング

### Design Tokens

共通のCSS変数は `src/styles/tokens.css` で管理されています：

```css
:root {
  --color-primary: #3b82f6;
  --spacing-md: 1rem;
  --font-size-base: 1rem;
  /* ... */
}
```

### Shadow DOM

Litコンポーネントは基本的にShadow DOMを使用します。グローバルなスタイルは、CSS Custom Propertiesを通じて適用されます。

## 🧪 テスト

テストファイルは実装ファイルと同じディレクトリに配置します：

```
features/diary/
├── components/
│   ├── DiaryEntry.ts
│   └── DiaryEntry.test.ts
```