{
  description = "Java development for Coding Contests";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-26.05";
  };

  outputs =
    { self, nixpkgs }:
    let
      system = "x86_64-linux";
      pkgs = import nixpkgs { inherit system; };
    in
    {
      devShells.${system}.default = pkgs.mkShell {
        buildInputs = with pkgs; [
          jdk25
          gradle
        ];

        shellHook = ''
          export JAVA_HOME=${pkgs.jdk25}
          export PATH=$JAVA_HOME/bin:$PATH

          echo "🎓 Coding Contests Java environment ready"
          java -version
        '';
      };
    };
}
