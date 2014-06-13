package edu.science.biology

enum Dictionary {
    enum PlaceInBody {
        ABDOMENO('abdomen, peritoneal, belly cavity'),
        ACRO('extremety', 'acromegaly - enlarged arms and feet'),
        ADENO('gland', 'adenoma - a tumor of some gland'),
        ANGIO('vessel', 'angiogram - a graph of vasculature'),
        ARTHRO('joint', 'arthritis - inflamation of joints'),
        CARDIO('heart'),
        CHONDRO('cartilage'),
        CYSTO('bladder, sac','cystitis - bladder infection'),
        CYTO('cell'),
        DENTO('tooth'),
        DERMATO('skin'),
        DERMO('skin'),
        DUODEMO('duodenum'),
        GASTRO('stomach', 'gistritis - inflamation of stomach'),
        HEPATO('liver', 'hepatoma - tumor of the liver, hepatits - infection of liver'),
        LARYNGO('larynx, voice box', 'laryngitis - inflamation of of larynx'),
        MYO('muscle'),
        NEPHRO('kidney'),
        NEURO('nerves'),
        OSTEO('bone'),
        OTO('ear'),
        PATHO('disease'),
        PNEUMONO('lung'),
        RHINO('nose'),
        STOMATO('mouth', 'stomatitis - inflamation inside the mouth'),
        THORACO('thorax, pleural, chest');

        String placeInBody
        String example

        PlaceInBody(String placeInBody, String example = '') {
            this.placeInBody = placeInBody
            this.example = example
        }
    }
}
