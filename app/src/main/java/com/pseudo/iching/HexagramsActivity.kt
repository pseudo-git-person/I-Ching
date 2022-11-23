package com.pseudo.iching

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


val HexStringArray = arrayOf<String>(
    "1. The Creative\n乾 (Ch'ien)" , "The universe is united in power. So too the wise person execute his actions with power and creativity. Exceptional progress comes by correct persistence.",
    "2. The Receptive\n坤 (K'un)" , "The receptive earth is in power. The wise person follows the natural path of calmness and correct persistence. Others may lead while you support their goals.",
    "3. The Difficulty\n屯 (Chun)" , "Thunderclouds indicate profound disquiet. Undertake no distant goal, but organize support. Concern yourself with the problems of the moment.",
    "4. The Folly\n蒙 (Meng)" , "As spring water collects at the base of the quiet mountain, the enlightened person finds his level through learning. decisiveness, and correct persistence.",
    "5. The Waiting\n需 (Hsu)" , "Waiting is not mere empty hoping. It has the inner certainty of reaching the goal. Such certainty alone gives that light which leads to success. This leads to the perseverance that brings good fortune and bestows power to cross the great water.",
    "6. The Conflict\n訟 (Song)" , "Heaven and water, strength and profundity, conflict. Avoid confrontation. Yield with caution. Persist not against obstacles.",
    "7. The Army\n師 (Shih)" , "The receptive earth holds the water, and the wise person will find strength in the company of many fellows. With leadership there will be correct persistence and good fortune.",
    "8. The Union\n比  (Pi)" , "The receptive earth beneath. with profundity above, indicates the need for unity and collective awareness of the goal.Do not procrastinate. Join with others and return to the plan.",
    "9. The Taming\n小畜 (Hsiao Ch'u)" , "The winds of gradual change. supported by the strength of Heaven,shows that restraint brings progress and satisfaction. Make minor changes and conceal all actions.",
    "10. The Treading\n履 (Lu)" , "The excessive beneath, the strong above. Discriminate between the inferior and superior to achieve progress. Change gives way to stability.",
    "11. The Peace\n泰 (T'ai)" , "The strength of Heaven mingles with the receptive earth. The wise leader benefits from this harmony. Good fortune approaches.",
    "12. The Standstill\n否 (P'i)" , "The strong and the receptive do not meet. Strong persons give way to the inferior. The enlightened person remains reserved to avoid misfortune. No advantage in persistence.",
    "13. The Fellowship\n同人 (T'ung Jen)" , "Strength of heaven dependence of fire. Recognize the dependence of all upon their fellows. The wise person seeks the collective flow to gain advantage.",
    "14. The Sovereignty\n大有 (Ta Yu)" , "The strength of heaven holds a fiery intelligence, the maker of an enlightened ruler. Resist evil; exalt good. Proper Leadership brings great progress.",
    "15. The Moderation\n謙 (Ch'ien)" , "The tranquil mountain amid the receptive earth indicates great progress through the reduction of excess. Progress comes by equality of extremes.",
    "16. The Enthusiasm\n豫 (Yu)" , "From the receptive earth comes the loud thunder. So from harmony with supporters does the wise person gain advantage.",
    "17. The Following\n隨 (Sui)" , "In the midst of excess, growth and persistence produces progress. The enlightened person adapts and leads the way from darkness to comfort.",
    "18. The Decay\n蠱 (Ku)" , "Winds of gradual change wear away the mountain. Cultivate action in others to bring about repair and great progress. If starting, meditate on the future.",
    "19. The Approach\n臨 (Lin)" , " The earth above reflecting the lake beneath. So is the enlightened person willing to teach and learn from others. Progress comes through persistence.",
    "20. The View\n觀 (Kuan)" , "As the wind moves over the earth, so too the rulers of old travelled the world. They visited its regions and contemplated its many cultures. Explore new ideas.",
    "21. The Reform\n噬嗑 (Shih Ho)" , "The turbulence of thunder and lightning indicates the need for change. Achieve progress through reform. Administer justice.",
    "22. The Serenity\n賁 (Pi)" , "Illumination reveals the foot of the immovable mountain. So the wise person perceives and avoids disputes. No progress except in small matters.",
    "23. The Deterioration\n剝 (Po)" , "The weak earth cannot support the mountain. The realm deteriorates. Enlightened people stabilize their lives through generosity toward the needy",
    "24. The Return\n復 (Fu)" , " The beginning of a new cycle shows that repetition brings new progress toward a goal. Friends return. The repeating cycle is part of the Way.",
    "25. The Innocence\n無妄 (Wu Wang)" , "Strength above and activity below indicates an alignment with a natural state. Act with persistence and inspiration but without a true goal.",
    "26. The Taming\n大畜 (Ta Ch'u)" , "The strength of the Heavens comes from within the mountain. The enlightened person studies the past's wisdom to develops his own character.",
    "27. The Nurturing\n頤 (Yi)" , "Energy stirs beneath immobility. Support goals that are above question, but be cautious in expression and avoid the negative. Correct persistence brings one goog fortune. ",
    "28. The Preponderance\n大過 (Ta Kuo)" , "The enlightened person withdraws from the world to progress toward an independent goal. Stress is imminent.",
    "29. The Danger\n坎 (K'an)" , "Profundity produces difficulty. The wise person learns confidence through danger. Remain calm in mind, keep all actions virtuous.",
    "30. The Clinging\n咸 (Li)" , " Intelligence shines above and below. The enlightened person cultivates intelligence and gains progress through correct persistence. Align yourself with goals that bring enlightenment.",
    "31. The Influence\n乾 (Hsien)" , "Tranquility combined with excess produces pleasure. Marriage brings good fortune. Accept others and act openly. All change is imminent.",
    "32. The Duration\n恆 (Heng)" , "Activity and change teach well the value of endurance. Stand firm and move with persistence toward a goal. Freedom from error.",
    "33. The Retreat\n遯 (Tun)" , "The tranquil mountain remains quiet under Heaven's gaze. So does the enlightened person maintain dignity in retreat. Persist only in small matters, and avoid mean conflict.",
    "34. The Power\n大壯 (Ta Chuang)" , "Activity in the light of day. The wise person acts within convention and with persistence. Use influence wisely.",
    "35. The Progress\n晉 (Chin)" , "The sun rises above the earth. So does the enlightened person reveal virtue. Conditions favorable for progress. Help others through cleverness and virtue.",
    "36. The Darkening\n明夷 (Ming I)" , "Intelligence is hidden within the earth. Conceal goals, but do not abandon them. Trying condition, but correct persistence brings one advantage.",
    "37. The Family\n家人 (Chia Jen)" , "Winds of change issue from intelligent action. The enlightened person acts in an orderly and substantial way. Faith and loyal ty must be nurtured.",
    "38. The Opposition\n睽 (K'uei)" , "Intelligence contradicts excess. The enlightened person acts only in small matters. Maintain individuality.",
    "39. The Obstruction\n蹇 (Chien)" , "Profound movement meets immobility. The enlightened person examines and perfects his own behavior to gain strength.",
    "40. The Deliverance\n解 (Hsieh)" , "Rain and thunder indicate profound activity. The enlightened person finds good fortune in quick action to restore normal conditions. Forgive others' faults.",
    "41. The Decrease\n損 (Sun)" , "Excess is held by immobility. The enlightened person acts with moderation. Avoid anger, develop confidence. Sacrifice brings good fortune, freedom from error.",
    "42. The Increase\n益 (I)" , "Growth brings benefit. An enlightened person sees the good actions of his fellows. Imitate them and correct their mistakes to make progress toward a goal.",
    "43. The Resoluteness\n夬 (Kuai)" , " Excess, drawn into Heaven's gaze, produces honesty. Do not use force, but rely on fair judges. Know your goal, tell your supporters.",
    "44. The Coming\n姤 (Kou)" , "Heaven's power makes stronger the wind of change. So too a ruler issues commands that become well known. Do not create a relationship with powerful persons or ideas. Exert discipline.",
    "45. The Gathering\n萃 (Ts'ui)" , " The earth receives excess. Unite with others, make sacrifices, and act with correct persistence to achieve a goal. Act with sincerity, avoid suspicion, and join with a wise leader.",
    "46. The Pushing\n升 (Sheng)" , "Gradual change, nourished by the receptive earth, produces a path to virtue. The enlightened person persists in small matters to gain fortune. Approach leaders without fear.",
    "47. The Adversity\n困 (K'un)" , "Excess lacks profundity. The enlightened person gains progress through courage. Adversity needs risks to achieve fortune. Speaking alone is ineffective.",
    "48. The Insight\n井 (Ching)" , "Profound penetration and change. Truth is never exhausted, yet never the same. The enlightened person gains insight into truth and assists others to achieve it. If the truth is not heeded, bad fortune follows.",
    "49. The Revolution\n革 (Ko)" , "Intelligent consciousness amid excess produces change. The enlightened person appreciates past experience and present opportunity. Confidence and progress only after change is past.",
    "50. The Cauldron\n鼎 (Ting)" , "Intelligence combined with penetration makes progress and good fortune. The wise person aligns himself with the established order.",
    "51. The Shock\n震 (Chen)" , "Repeated activity produces sudden surprise and fear. The enlightened person seeks to improve himself and take advantage of the unpredictable.",
    "52. The Still\n艮 (Ken)" , " Tranquility upon tranquility. The enlightened person turns his back upon the larger situation and loses self awareness. Should he not notice anyone else, there is no error.",
    "53. The Development\n漸 (Jian)" , "Penetrating change moves the immobile mountain. The enlightened person improves life through good conduct and correct persistence. Marriage brings good fortune.",
    "54. The Marrying\n歸妹 (Kuei Mei)" , "Action above, excess below. The enlightened person in current difficulty takes no action but considers the near future. Seek no goal.",
    "55. The Abundance\n豐 (Feng)" , "Intelligence combined with activity. This is the zenith of achievement. The enlightened person trusts his own judgment and makes progress. Do not fear decline, but shine like the sun.",
    "56. The Wanderer\n旅 (Lu)" , "Illumination upon the quiet mountain makes conditions favorable for travel. The wise person is clear-minded and not detained by disputes.",
    "57. The Gentle\n巽 (Xun)" , "Penetrating change above and below. The enlightened person acts gradually and only toward small goals. Wait and consider larger perspectives.",
    "58. The Joyous\n兌 (Tui)" , "Openness and excess above and below. The wise person exchanges ideas with others to find cooperation. Progress and advantage in correct persistence.",
    "59. The Dispersion\n渙 (Huan)" , "Gradual change above the profound water. Rulers meet with their subordinates. Advantage in cooperation, correct persistence, and the company of fellows.",
    "60. The Limitation\n節 (Chieh)" , "Profundity is held in check by excess. The wise person develops sound restraints and decides proper conduct. Extreme limitation, though. is no virtue.",
    "61. The Truth\n中孚 (Chung Fu)" , "Penetrating change above the open lake. From a distance the wise person gains understanding. Moderate disputes, and must avoid rigidity.",
    "62. The Small\n小過 (Hsiao Kuo)" , "As the mountain remains tranquil in activity, so the wise person conducts himself with dignity and control. Be remorseful in losses and frugal in expenses. When birds fly too high, none hear their song.",
    "63. The After\n既濟 (Chi Chi)" , "In consciousness is bred profound difficulty. The enlightened person defends against forthcoming adversity. Progress only in small matters. Confusion is imminent.",
    "64. The Before\n未濟 (Wei Chi)" , "Consciousness above the difficult water. The wise person attends his position and progress carefully. Progress with great vigilance."
)


val HexURLArray = arrayOf<String> (
    "https://i.imgur.com/KcUGATT.png",
    "https://i.imgur.com/OnrsS5e.png",
    "https://i.imgur.com/IBCkDcY.png",
    "https://i.imgur.com/t59bUR5.png",  //4
    "https://i.imgur.com/9yLojW8.png",
    "https://i.imgur.com/zYYv4lw.png",
    "https://i.imgur.com/rDEH4Ir.png",
    "https://i.imgur.com/FR14ysr.png",  //8
    "https://i.imgur.com/02JKA67.png",
    "https://i.imgur.com/rbQMKxL.png",
    "https://i.imgur.com/Ef6LYwe.png",
    "https://i.imgur.com/gj2R0B9.png",  //12
    "https://i.imgur.com/Gj58sKP.png",
    "https://i.imgur.com/9CJoUWz.png",
    "https://i.imgur.com/sVP7VE9.png",
    "https://i.imgur.com/msjAPUr.png", //16
    "https://i.imgur.com/7VuWIWF.png",
    "https://i.imgur.com/PpwiwIf.png",
    "https://i.imgur.com/J3LkxXL.png",
    "https://i.imgur.com/eZvv0tR.png", //20
    "https://i.imgur.com/VEiZwYY.png",
    "https://i.imgur.com/tNbMbtT.png",
    "https://i.imgur.com/6ZBPbZw.png",
    "https://i.imgur.com/W84E6oY.png", //24
    "https://i.imgur.com/F6qeM5U.png",
    "https://i.imgur.com/35pCKDP.png",
    "https://i.imgur.com/Spuj9H0.png",
    "https://i.imgur.com/u9hJQsW.png", //28
    "https://i.imgur.com/80cMfZJ.png",
    "https://i.imgur.com/DJqwRqf.png",
    "https://i.imgur.com/8d3Jc1B.png",
    "https://i.imgur.com/buXok64.png", //32
    "https://i.imgur.com/Z94wT6Z.png",
    "https://i.imgur.com/9pqnTHA.png",
    "https://i.imgur.com/bncxsgW.png",
    "https://i.imgur.com/F0mdoua.png", //36
    "https://i.imgur.com/x9DNMiy.png",
    "https://i.imgur.com/jSgaVZz.png",
    "https://i.imgur.com/uTCBdgY.png",
    "https://i.imgur.com/7PhHaip.png", //40
    "https://i.imgur.com/j3Ku2Ke.png",
    "https://i.imgur.com/c8roMVp.png",
    "https://i.imgur.com/Zbx4CIa.png",
    "https://i.imgur.com/e5mq4hz.png", //44
    "https://i.imgur.com/GK918Tg.png",
    "https://i.imgur.com/D72KT9E.png",
    "https://i.imgur.com/p0Znyce.png",
    "https://i.imgur.com/52fS1rY.png", //48
    "https://i.imgur.com/Bd1xrpG.png",
    "https://i.imgur.com/0xYIBku.png",
    "https://i.imgur.com/8RnIC8b.png",
    "https://i.imgur.com/vpqqR0Q.png", //52
    "https://i.imgur.com/cJKKRrD.png",
    "https://i.imgur.com/070NcSn.png",
    "https://i.imgur.com/r3sETkF.png",
    "https://i.imgur.com/NVaCcPn.png", //56
    "https://i.imgur.com/os0osaU.png",
    "https://i.imgur.com/RlceOPV.png",
    "https://i.imgur.com/SoB4Azx.png",
    "https://i.imgur.com/QUztjV0.png", //60
    "https://i.imgur.com/yMXB5oq.png",
    "https://i.imgur.com/dbnuaq4.png",
    "https://i.imgur.com/QrZ9SHs.png",
    "https://i.imgur.com/WY9bcSO.png" //64

)



class HexagramsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hexagrams)

        for (i in 0..63)
        {
            val titleText = HexStringArray[(i)*2].replace("\n","\t")
            val descriptionText = HexStringArray[(i)*2+1]

            val parent = LinearLayout(this)
            parent.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            parent.orientation = LinearLayout.HORIZONTAL

            //children
            val iv = ImageView(this)
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            lp.setMargins(0, 140, 20, 0)
            iv.setLayoutParams(lp)
            iv.getLayoutParams().height = 200
            iv.getLayoutParams().width = 200

            Glide
                .with(this)
                .load(HexURLArray[i])
                .into(iv);

            parent.addView(iv)


            val linearCH = LinearLayout(this)
            linearCH.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            linearCH.orientation = LinearLayout.VERTICAL

            // TextView1
            val tv1 = TextView(this)
            val lptv1 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            lptv1.setMargins(60, 60, 0, 0)

            tv1.setLayoutParams(lptv1)
            tv1.setText(titleText) // title
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
            tv1.textAlignment = View.TEXT_ALIGNMENT_CENTER

            // TextView2
            val tv2 = TextView(this)
            val lptv2 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            lptv2.setMargins(0, 11, 7, 0)

            tv2.setLayoutParams(lptv2)
            tv2.setText(descriptionText) // description
            tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13F)
            tv2.textAlignment = View.TEXT_ALIGNMENT_CENTER


            linearCH.removeAllViews()
            linearCH.addView(tv1)
            linearCH.addView(tv2)

            parent.removeAllViews()
            parent.addView(iv)
            parent.addView(linearCH)

            val finalParent = this.findViewById(R.id.rootLinearLayout) as ViewGroup
            finalParent.addView(parent)


        }



    }
}

