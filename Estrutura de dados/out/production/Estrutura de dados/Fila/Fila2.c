        #include <stdio.h>
        #include <stdlib.h>

        struct cel {
            int conteudo;
            struct cel *seg; // seguinte
        };
        typedef struct cel celula;

        void insere(celula **inicio, celula **fim, int x) {
            celula *novo = malloc(sizeof(celula));
            novo->conteudo = x;
            novo->seg = NULL;
            if (*inicio == NULL) {
                *inicio = novo;
                *fim = novo;
            } else{
                (*fim)->seg = novo;
                *fim = novo;
            }
        }
            

        void remove_celula (celula **inicio, celula **fim){
                celula *lixo;
                lixo = *inicio;
                if(*inicio == *fim){
                    free(lixo);
                }else{
                    *inicio = (*inicio)->seg;
                    free(lixo);
                }
        }

        void main() {
            celula *inicio;
            inicio = NULL;
            celula *fim;
            fim = NULL;

            for (int i = 0; i < 10; i++) {
                insere(&inicio, &fim, i);
            }
            for(int i = 0 ; i <10; i++){
                remove_celula(&inicio,&fim);
            }
        }