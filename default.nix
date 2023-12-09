{ pkgs ? import <nixpkgs> {}}:

pkgs.mkShell {
      packages = with pkgs; [
          neovim
          vimPlugins.telescope-file-browser-nvim
          vimPlugins.nvim-treesitter
          vimPlugins.nvim-treesitter.withAllGrammars
          clojure
          leiningen
          zprint
          clojure-lsp
      ];

      shellHook = ''
          # This is a hack to get around `alias` not working with direnv/nix
          export DIR=$(mktemp --directory --tmpdir=/tmp)
          export PATH="$DIR:$PATH"
          echo 'nvim $@' > $DIR/vim
          chmod +x $DIR/vim
      '';
}
